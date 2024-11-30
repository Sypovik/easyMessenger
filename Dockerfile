FROM ubuntu
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    maven \
    && apt-get clean

# Устанавливаем переменную окружения для Java
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Указываем рабочую директорию
WORKDIR /app

# Копируем содержимое проекта
COPY . .