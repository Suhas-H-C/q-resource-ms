#!/bin/bash

# Artist endpoints
echo "Testing Artist endpoints..."
curl -v http://localhost:8667/artists
curl -v http://localhost:8667/artists/1
curl -v -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"bio\":\"peter is good in singing\",\"age\":25}" http://localhost:8667/artists
curl -v -X DELETE http://localhost:8667/artists/3

# Student endpoints
echo "Testing Student endpoints..."
curl -v http://localhost:8667/std
curl -v http://localhost:8667/std/1
curl -v -X POST -H "Content-Type:application/json" -d "{\"name\":\"peter\",\"standard\":5}" http://localhost:8667/std
curl -v -X DELETE http://localhost:8667/std/3

echo "All tests completed"