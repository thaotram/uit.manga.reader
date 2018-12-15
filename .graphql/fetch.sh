SCHEMA_PATH="http://localhost:3000/api/graphql"

get-graphql-schema $SCHEMA_PATH > "app/src/main/graphql/apollographql/apollo/schema.json" --json
