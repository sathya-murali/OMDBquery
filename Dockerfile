FROM ubuntu:14.04
COPY queryAPI.sh $HOME 
RUN sudo apt-get -y update
RUN sudo apt-get -y install curl
RUN curl --version
RUN /bin/bash -c "chmod u+x queryAPI.sh; ./queryAPI.sh"
