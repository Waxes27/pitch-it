import requests
import json



user_list = []


for i in range(50):
    print(i)
    user_data = requests.get("https://api.namefake.com/").text
    json_data = json.loads(user_data)
    user_dict = {}
    
    for i in json_data:
        user_dict[i] = str(json_data[i]).replace('"',"-")
        user_dict["practice"] = "test practice"
    user_list.append(user_dict)
    


with open("user_data.json","w") as f:
    f.write(str(user_list).replace("'",'"'))
    print(user_list)


