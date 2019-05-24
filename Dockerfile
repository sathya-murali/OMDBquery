FROM ubuntu:19.04
COPY queryOMDBAPI.groovy $HOME/
RUN apt-get -y update
RUN apt-get -y install wget unzip && \
    apt-get clean && \
    cd /tmp
RUN \
  apt-get -y update && \
  apt-get -y install default-jre && \
  apt-get -y install default-jdk && \
  ln -s /usr/lib/jvm/java-11-openjdk-amd64 /usr/src/java7 && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer && \
  java --version

RUN cd /tmp && \
    wget http://dl.bintray.com/groovy/maven/apache-groovy-binary-2.5.7.zip && \
    unzip apache-groovy-binary-2.5.7.zip && \
    mv groovy-2.5.7 /usr/src/groovy && \
    rm apache-groovy-binary-2.5.7.zip

ENV JAVA_HOME /usr/src/java7
ENV GROOVY_HOME /usr/src/groovy
ENV PATH $GROOVY_HOME/bin/:$PATH
CMD groovy ./queryOMDBAPI.groovy