from pyes import *


conn = ES('127.0.0.1:9200')
quer = {
     "query": {
         "query_string" : {
         "default_field" : "data",
         "query" : "200"
        }
     }
  }

response=conn.search_raw(quer)
print("Time in milliseconds for Elasticsearch to execute the search:")
print("{} ms".format(response.took))
