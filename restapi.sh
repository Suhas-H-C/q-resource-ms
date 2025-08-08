#!/bin/bash

# Artist endpoints
echo "Job started..."
curl -v http://localhost:8667/artists
echo "All artists fetched successfully"
curl -v http://localhost:8667/artists/1
echo "Artist with Id 1 fetched successfully"
curl -v -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"bio\":\"peter is good in singing\",\"age\":25}" http://localhost:8667/artists
echo "Artist Peter persisted successfully"
curl -v -X DELETE http://localhost:8667/artists/3
echo "Artist with Id 3 removed successfully"

# Student endpoints
echo "Testing Student endpoints..."
curl -v http://localhost:8667/std
echo "All student fetched successfully"
curl -v http://localhost:8667/std/1
echo "Student with Id 1 fetched successfully"
curl -v -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"standard\":5}" http://localhost:8667/std
echo "Student Peter persisted successfully"
curl -v -X DELETE http://localhost:8667/std/3
echo "Student with Id 3 removed successfully"

echo "Job completed."