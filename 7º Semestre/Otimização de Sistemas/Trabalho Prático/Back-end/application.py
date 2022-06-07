# ---------- import libs ---------
from flask import Flask, request

# ---------- import functions ---------
from optimize import aplicateCplex

# ----------- routes and applications --------
# EB looks for an 'application' callable by default.
application = Flask(__name__)

# Root page
@application.route("/")
def hello_world():
    return "Python PL optimization!"

@application.route("/optimization", methods=["POST"])
def optimization():
    if request.method == "POST":
        return aplicateCplex(request.json)

# run the app.
if __name__ == "__main__":
    # Setting debug to True enables debug output. This line should be
    # removed before deploying a production app.
    # application.debug = True
    application.run()