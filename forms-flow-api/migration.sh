#!/bin/bash
echo 'run camunda_authorization_migration.py'
python src/migration_scripts/invoke_scripts.py "$@"
