#!/usr/bin/env bash

commitdate="$(date)"
git pull
git add --all
git commit -m "$commitdate"
git push #-u origin main
git pull
 

