from flask import Flask, render_template, request, redirect, url_for, flash
import requests
import os

API_BASE = os.environ.get("ECOCOLETA_API", "http://localhost:8080/api")

app = Flask(__name__)
app.secret_key = os.environ.get("FLASK_SECRET_KEY", "dev-secret")

def api_get(path, params=None):
    url = f"{API_BASE}{path}"
    r = requests.get(url, params=params or {}, timeout=10)
    r.raise_for_status()
    return r.json()

def api_post(path, json_body):
    url = f"{API_BASE}{path}"
    r = requests.post(url, json=json_body, timeout=10)
    r.raise_for_status()
    return r.json()

def api_put(path, json_body):
    url = f"{API_BASE}{path}"
    r = requests.put(url, json=json_body, timeout=10)
    r.raise_for_status()
    return r.json()

def api_delete(path):
    url = f"{API_BASE}{path}"
    r = requests.delete(url, timeout=10)
    if r.status_code not in (200, 204):
        r.raise_for_status()
    return True

@app.route("/")
def index():
    types = api_get("/types")
    return render_template("index.html", types=types)

@app.route("/points")
def points():
    q_type = request.args.get("type") or ""
    lat = request.args.get("lat") or ""
    lng = request.args.get("lng") or ""
    radius = request.args.get("radiusKm") or ""
    params = {}
    if q_type: params["type"] = q_type
    if lat: params["lat"] = lat
    if lng: params["lng"] = lng
    if radius: params["radiusKm"] = radius

    try:
        items = api_get("/points", params=params)
        types = api_get("/types")
    except Exception as e:
        flash(f"Erro ao carregar pontos: {e}", "danger")
        items = []
        types = []
    return render_template("points_list.html",
                           points=items, types=types,
                           filters={"type": q_type, "lat": lat, "lng": lng, "radiusKm": radius})

@app.route("/points/new", methods=["GET", "POST"])
def point_new():
    types = api_get("/types")
    if request.method == "POST":
        try:
            payload = {
                "name": request.form["name"],
                "address": request.form["address"],
                "latitude": float(request.form["latitude"]),
                "longitude": float(request.form["longitude"]),
                "acceptedTypes": request.form.getlist("acceptedTypes"),
                "hours": request.form.get("hours", ""),
                "phone": request.form.get("phone", ""),
            }
            created = api_post("/points", payload)
            flash("Ponto criado com sucesso!", "success")
            return redirect(url_for("points"))
        except Exception as e:
            flash(f"Erro ao criar ponto: {e}", "danger")
    return render_template("point_form.html", types=types, data={}, action="create")

@app.route("/points/<int:pid>")
def point_detail(pid):
    try:
        data = api_get(f"/points/{pid}")
        return render_template("point_detail.html", data=data)
    except Exception as e:
        flash(f"Ponto não encontrado: {e}", "warning")
        return redirect(url_for("points"))

@app.route("/points/<int:pid>/edit", methods=["GET", "POST"])
def point_edit(pid):
    types = api_get("/types")
    if request.method == "POST":
        try:
            payload = {
                "name": request.form["name"],
                "address": request.form["address"],
                "latitude": float(request.form["latitude"]),
                "longitude": float(request.form["longitude"]),
                "acceptedTypes": request.form.getlist("acceptedTypes"),
                "hours": request.form.get("hours", ""),
                "phone": request.form.get("phone", ""),
            }
            updated = api_put(f"/points/{pid}", payload)
            flash("Ponto atualizado com sucesso!", "success")
            return redirect(url_for("point_detail", pid=pid))
        except Exception as e:
            flash(f"Erro ao atualizar ponto: {e}", "danger")
    else:
        try:
            data = api_get(f"/points/{pid}")
        except Exception as e:
            flash(f"Ponto não encontrado: {e}", "warning")
            return redirect(url_for("points"))
    return render_template("point_form.html", types=types, data=data, action="edit", pid=pid)

@app.route("/points/<int:pid>/delete", methods=["POST"])
def point_delete(pid):
    try:
        api_delete(f"/points/{pid}")
        flash("Ponto removido com sucesso!", "success")
    except Exception as e:
        flash(f"Erro ao remover ponto: {e}", "danger")
    return redirect(url_for("points"))

if __name__ == "__main__":
    app.run(debug=True, port=5000)
