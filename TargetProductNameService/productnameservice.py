from flask import Flask, request, Response
import json

""""
Product name webservice to get and post product name
endpoints:
    GET   /products/<id> gives product json with id and name if product exists in dictionary
    POST  /products  adds a product id and its corresponding name to the dictionary
"""
app = Flask(__name__)
products = dict()


@app.route("/products/<id>")
def get_product(id):
    """
    api method to get a product details by its id from products dictionary
    :param id: product id
    :type id: int
    :return: json
    :returns : product id and name if product exists / 404 not found if id is empty /
               id and None if product is not found
    """
    _product = dict()
    _product["id"] = id
    _product["name"] = products.get(id, None)
    return json.dumps(_product)


@app.route("/products", methods=['POST'])
def add_product():
    """
    api method to add a product and its name to products dictionary
    :return: Response object
    :returns Response 200 on success / Response 400 for missing or invalid data
    """
    if not request.data:
        return Response(status=400)
    id = None
    name = ""
    data = json.loads(request.data)
    for key, val in data.items():
        if key == "id":
            id = val
        if key == "name":
            name = val
    if not name or not id:
        return Response(status=400)
    products[id] = name
    print("adding product {0} {1}".format(id, name))
    return Response(status=201)


if __name__ == "__main__":
    app.run(port=8100)
