#!/bin/bash
docker run -d --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=changeit -p 5432:5432 postgres:17.2
