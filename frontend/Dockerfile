# build stage
FROM node:lts-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# production stage
FROM nginx:stable-alpine
COPY --from=0 /app/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]