FROM openjdk:8u222-jdk
RUN mkdir car-test
ADD . car-test
WORKDIR /car-test
RUN sed -i 's/\r$//' init.sh
CMD [ "/bin/bash","init.sh" ]