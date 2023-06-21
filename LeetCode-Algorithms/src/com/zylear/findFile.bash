#!/bin/bash

function find_files {
    for fileName in "$1"/*; do
        if [[ -d "$fileName" ]]; then
            find_files "$fileName" "$2"
        elif [[ -f "$fileName" && "$fileName" == *.log && $(grep -c "$2" "$fileName") -ne 0 ]]; then
            echo "$fileName"
        fi
    done
}

find_files "/var/log" "abc"


