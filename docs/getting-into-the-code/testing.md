# How to test

For details on unit testing see [https://devdocs.jabref.org/getting-into-the-code/code-howtos\#test-cases](https://devdocs.jabref.org/getting-into-the-code/code-howtos#test-cases).

## Database tests

### PostgreSQL

To quickly host a local PostgreSQL database, execute following statement:

```text
docker run -d -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 --name db postgres:10 postgres -c log_statement=all
```

Set the environment variable `DBMS` to `postgres` \(or leave it unset\)

Then, all DBMS Tests \(annotated with `@org.jabref.testutils.category.DatabaseTest`\) run properly.

### MySQL

A MySQL DBMS can be started using following command:

```text
docker run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=jabref -p 3800:3307 mysql:8.0 --port=3307
```

Set the environment variable `DBMS` to `mysql`.


###  Entry Type Factory 

Is Equal Name and Field Based Test Cases:

| Test Case      | Input                          | Expected Output               |
| -------------- | ------------------------------ |------------------------------ |
| 1    | Type1 =  null and Type2 = null  | True
| 2     | Type1 !=  null and Type2 = null  | False
| 3    | Type1 =  null and Type2 != null  | False
| 4    | Type1 !=  null and Type2 != null  and Type1!= Type2 | False
| 5    | Type1 !=  null and Type2 != null  and Type1 = Type2 | True

