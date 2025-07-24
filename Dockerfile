FROM bellsoft/liberica-openjdk-alpine

#Install curl jq
RUN apk add curl jq

#workspcae
WORKDIR /home/selenium-docker

# add required files
ADD target/docker-resources      ./
ADD runner.sh                     runner.sh

# environment varaibles
# browser
# hubhost
# test_suite
# thread_count

#run the test<entry point>
#ENTRYPOINT java -cp "libs/*" \
#           -Dselenium.grid.enabled=true \
#           -Dselenium.grid.hub.host=${HUB_HOST} \
#           -Dbrowser=${BROWSER} \
#            org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#            ${TEST_SUITE}
ENTRYPOINT sh runner.sh

