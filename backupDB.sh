#!/bin/sh

docker exec mongo sh -c 'exec mongodump -d dama --archive' > /Users/roman/Work/dama/db_backups/dama-`date +%d.%m.%y_%H:%M:%S`.archive