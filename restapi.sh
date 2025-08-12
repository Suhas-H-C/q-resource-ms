#!/bin/bash

# Artist endpoints
echo -e "Job started...\n"

curl http://localhost:8667/artists
echo -e "\nAll artists fetched successfully\n"
curl http://localhost:8667/artists/1
echo -e "\nArtist with Id 1 fetched successfully\n"
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"bio\":\"peter is good in singing\",\"age\":25}" http://localhost:8667/artists
echo -e "\nArtist Peter persisted successfully\n"
curl -X DELETE http://localhost:8667/artists/3
echo -e "\nArtist with Id 3 removed successfully\n"

# Student endpoints
echo -e "\nTesting Student endpoints...\n"
curl http://localhost:8667/std
echo -e "\nAll student fetched successfully\n"
curl http://localhost:8667/std/1
echo -e "\nStudent with Id 1 fetched successfully\n"
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"standard\":5}" http://localhost:8667/std
echo -e "\nStudent Peter persisted successfully\n"
curl -X DELETE http://localhost:8667/std/3
echo -e "\nStudent with Id 3 removed successfully\n"

# Book endpoints
echo -e "\nTesting Book endpoints...\n"
curl -X POST "http://localhost:8667/v1/save" -H "Content-Type: application/x-www-form-urlencoded" -H "Accept: application/json" -d "title=The Hobbit" -d "author=J.R.R. Tolkien" -d "yearOfPublication=1937" -d "genre=Fantasy"

# Employee endpoints
echo -e "Testing Employee endpoints...\n"
curl http://localhost:8667/v1/emp
echo -e "\nAll employees fetched successfully\n"
curl http://localhost:8667/v1/emp/1
echo -e "\nEmployee with Id 1 fetched successfully\n"

# Greet endpoints
echo -e "\nTesting Greet endpoints...\n"
curl -X GET -H "Accept: text/plain" http://localhost:8667/v1/greet?name=John


echo -e "\nJob completed."