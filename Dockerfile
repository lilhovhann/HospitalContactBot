FROM registry.gitlab.com/armdev/dockers/openjdk15
COPY target/hospital_contact.jar /opt/hospital_contact.jar
RUN useradd -ms /bin/sh mphic2050 \
    && echo "root:Docker!" | chpasswd \
    && chown -R mphic2050 /opt/
USER mphic2050
ENTRYPOINT ["java", "-jar","/opt/hospital_contact.jar"]

EXPOSE 9898



