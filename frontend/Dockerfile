# Stage 1
FROM node:14.15.4 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm install -g @angular/cli@13
RUN ng build --configuration production
# RUN npm run build --prod
# Stage 2
FROM nginx:alpine
COPY --from=node /app/dist/global-medical /usr/share/nginx/html
# COPY default.conf /etc/nginx/conf.d/

# docker build -t pitchit/angular-app .
