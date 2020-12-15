##URL Shortening Service 리눅스 빌드 및 설치

------------

###1. java 설치 확인(설치 되지 않았다면 java 설치)
	-- java 설치 확인 명령어
	```
	$ java -version
	```

###2. maven 설치 확인(설치 되지 않았다면 maven 설치)
	-- maven 설치 확인 명령어
	```
	$ mvn -v
	```
	
	-- java8 설치 명령어(java8로 개발) 및 maven 설치 명령어
	```
	$ sudo apt -y install openjdk-8-jre-headless openjdk-8-jdk-headless maven
	```

###3. maven 빌드(pom.xml이 위치하고 있는 곳에서 실행합니다.)
	```
	$ mvn package
	```

###4. 설치(80 port로 설정되어 있어서 root 권한에서 실행해야 합니다.)
	```
	$ java -jar target/musinsa-khg-1-0.0.1-SNAPSHOT.jar
	```

------------
