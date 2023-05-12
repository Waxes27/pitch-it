FROM node:14.15.4 as node
WORKDIR /app
COPY . .
# RUN npm install
# RUN npm run build --prod
# Stage 2
FROM nginx:alpine
COPY --from=node /app/dist/angular-chat-app /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/
