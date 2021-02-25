import requests
url = "http://localhost:8080/api/v1/user"
r = requests.get(url)
print(r.text)

pload = {"username": "uname", "email": "email@email.com", "name": "FirstLast"}
r = requests.post(url, json=pload)
print(r.text)

url = "http://localhost:8080/api/v1/user/2" #deletes user 2
r = requests.delete(url, json=pload)
print(r.text)

url = "http://localhost:8080/api/v1/user/1?name=SSS" #changes name of user 1 to SSS
#OR
#url = "http://localhost:8080/api/v1/user/1?name=SSS&email=SSS@gmail.com"
r = requests.put(url)
print(r.text)
