#!/bin/bash
echo -e "Job Started...\n"
docker run -d --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=changeit -p 5432:5432 postgres:17.2
echo -e "\npostgres is up and running\n"
docker run -d --name mailhog -p 1025:1025 -p 8025:8025 mailhog/mailhog
echo -e "\nmailhog is up and running\n"
echo -e "\nJob completed...."