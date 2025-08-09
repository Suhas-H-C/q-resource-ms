#!/bin/bash

# Artist endpoints
echo "Job started...\n"

curl http://localhost:8667/artists
echo -e "All artists fetched successfully\n"
curl http://localhost:8667/artists/1
echo -e "Artist with Id 1 fetched successfully\n"
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"bio\":\"peter is good in singing\",\"age\":25}" http://localhost:8667/artists
echo -e "Artist Peter persisted successfully\n"
curl -X DELETE http://localhost:8667/artists/3
echo -e "Artist with Id 3 removed successfully\n"

# Student endpoints
echo -e "Testing Student endpoints...\n"
curl http://localhost:8667/std
echo -e "All student fetched successfully\n"
curl http://localhost:8667/std/1
echo -e "Student with Id 1 fetched successfully\n"
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"standard\":5}" http://localhost:8667/std
echo -e "Student Peter persisted successfully\n"
curl -X DELETE http://localhost:8667/std/3
echo -e "Student with Id 3 removed successfully\n"

echo "Job completed."