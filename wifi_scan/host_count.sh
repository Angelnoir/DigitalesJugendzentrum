#!/bin/bash
hosts=$(nmap -sn 192.168.44.1/22 | tail -n 1 | cut -d'(' -f2 | cut -d " " -f1)
#wait
query="{\"count\":$hosts}"
echo $query
curl -X POST -H "X-Parse-Application-Id:604b921fe3728d7bd9540b79a4247aa98a7963ef " -H "Content-Type: application/json" -d $query http://192.168.44.9/parse/classes/hosts

