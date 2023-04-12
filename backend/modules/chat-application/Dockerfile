FROM openjdk:17.0.2-jdk-slim

# Install dependencies
RUN apt-get update && \
    apt-get install -y gnupg2 && \
    apt-get install -y curl && \
    apt-get install -y supervisor

# Install Node.js
RUN curl -sL https://deb.nodesource.com/setup_14.x | bash -
RUN apt-get install -y nodejs

# Create directories for the applications
RUN mkdir -p /usr/app/chat-auth-service && \
    mkdir -p /usr/app/chat-messaging && \
    mkdir -p /usr/app/chat-client

# Copy the applications to the container
COPY /modules/chat-auth-service/target/auth-service-0.0.1-SNAPSHOT.jar /usr/app/chat-auth-service/auth-service-0.0.1-SNAPSHOT.jar
COPY /modules/chat-messaging/target/messaging-0.0.1-SNAPSHOT.jar /usr/app/chat-messaging/messaging-0.0.1-SNAPSHOT.jar
COPY /modules/chat-client /usr/app/chat-client

WORKDIR /usr/app/chat-client

VOLUME /var/log/

RUN npm install
RUN npm run build
RUN npm install -g serve
ENV NODE_ENV production

# Copy the supervisord configuration file
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# Expose ports
EXPOSE 8080 3000

# Start supervisord
CMD ["/usr/bin/supervisord", "-c", "/etc/supervisor/conf.d/supervisord.conf"]
