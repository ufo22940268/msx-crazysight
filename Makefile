.PHONY : main
main: 
	mvn -Dmaven.test.skip=true install android:redeploy  android:run -q

.PHONY : test
test:
	mvn test -q  -f test_pom.xml
