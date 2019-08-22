from flask import Flask, Response, request, redirect,  url_for,abort, session
import json
from json import dumps

app = Flask(__name__)

@app.route('/res.json')
def home():
    with open("res.json", "r") as f:
        content = f.read()
    return Response(json.dumps(content), mimetype="application/json")


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80)
