FROM openjdk:8-oracle

WORKDIR /home

# Copy jar
COPY ./target/app.jar /home

ADD scripts/entrypoint.sh /
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
