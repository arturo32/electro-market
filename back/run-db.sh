#!/bin/bash
sudo pkill -u postgres
sudo docker run --network="host" -it electro-market-db
