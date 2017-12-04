from flask import Flask, request, Response
import json
app = Flask(__name__)

products = dict()


@app.route("/")
def hello():
    return "Hello World!"


@app.route("/products/<id>")
def get_product(id):
    _product = dict()
    _product["id"] = id
    _product["name"] = products.get(id, None)
    return json.dumps(_product)


@app.route("/products", methods=['POST'])
def add_product():
    id = None
    name = ""
    data = json.loads(request.data)
    for key, val in data.items():
        if key == "id":
            id = val
        if key == "name":
            name = val
    products[id] = name
    # log.info("adding product {0} {1}".format(id, name))
    print("adding product {0} {1}".format(id, name))
    return Response(status=201)


if __name__ == "__main__":
    app.run(port=8100)
