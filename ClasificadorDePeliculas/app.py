from flask import Flask
from flask import request
import motor as m
import re


app = Flask(__name__)

@app.route('/classifyMovie', methods=['POST'])
def hello_world():
    data = request.get_json()
    score = data["score"]
    if(score != ""):
        try:
            scoreresult = eval(score)
            if(scoreresult >= 0.65):
                data["result"] = "fresh"
            else:
                data["result"] = "rotten" 
        except:
            data["result"] = "bad score input"
    else:
        review = data["review_content"]
        review = review.lower()
        review = re.sub(r'[-|-|?|/|,|<|.|>|:|;|\'|"|{|}|\\|=|+|_|)|(|*|&|^|%|$|#|@|!|`|~|/|\[|\]]', '', review)
        review = re.sub(r'\s+', ' ', review)
        data["review_content"] = review
        prob_fresh  = m.generacion_querys_fresh(data["review_content"])
        prob_rotten  = m.generacion_querys_rotten(data["review_content"])
        if(prob_fresh>= prob_rotten):
            data["result"] = "fresh"
        else:
            data["result"] = "rotten"
    return data
        
if __name__ == '__main__':
    app.run(debug=True)