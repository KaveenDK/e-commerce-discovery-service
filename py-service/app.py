from flask import Flask, jsonify
import py_eureka_client.eureka_client as eureka_client

app = Flask(__name__)

CONTEXT_PATH = "/py-service"

# Eureka Configuration
EUREKA_SERVER = "http://localhost:8761/eureka/"
SERVICE_PORT = 5000  # Customer Service port

# Register the service with Eureka
eureka_client.init(
    eureka_server=EUREKA_SERVER,
    app_name="PY-SERVICE",
    instance_port=SERVICE_PORT
)

# Sample Customer Data API
@app.route(f'{CONTEXT_PATH}/hello', methods=["GET"])
def get_customers():
    customers = [
        {"id": 1, "name": "John Doe", "email": "john@example.com"},
        {"id": 2, "name": "Jane Doe", "email": "jane@example.com"},
    ]
    return jsonify(customers)

if __name__ == "__main__":
    app.run(port=SERVICE_PORT)