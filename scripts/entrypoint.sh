#!/bin/bash

args="$@"

cmd="java -Djava.security.egd=file:/dev/./urandom -jar app.jar $args"
echo "$cmd"
$cmd
