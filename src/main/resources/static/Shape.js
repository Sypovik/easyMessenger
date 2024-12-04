export class Shape {
    // Конструктор класса, инициализирующий позицию, размер, цвет и скорость фигуры
    constructor(x, y, width, height, color, keys) {

        this.x = x; // Начальная позиция по оси X
        this.y = y; // Начальная позиция по оси Y
        this.width = width; // Ширина фигуры
        this.height = height; // Высота фигуры
        this.color = color; // Цвет фигуры
        this.speed = 5; // Скорость движения фигуры
        this.keys = keys; // Клавиши для управления фигурой
    }

    // // Метод для рисования фигуры на canvas
    // draw(ctx) {
    //     ctx.fillStyle = this.color; // Установка цвета заливки
    //     ctx.fillRect(this.x, this.y, this.width, this.height); // Рисование прямоугольника
    // }

    // Методы для перемещения фигуры в разные стороны
    moveUp() {
        this.y -= this.speed; // Перемещение вверх
    }

    moveDown() {
        this.y += this.speed; // Перемещение вниз
    }

    moveLeft() {
        this.x -= this.speed; // Перемещение влево
    }

    moveRight() {
        this.x += this.speed; // Перемещение вправо
    }

    // Методы для диагонального движения
    moveUpLeft() {
        this.x -= this.speed; // Перемещение влево
        this.y -= this.speed; // Перемещение вверх
    }

    moveUpRight() {
        this.x += this.speed; // Перемещение вправо
        this.y -= this.speed; // Перемещение вверх
    }

    moveDownLeft() {
        this.x -= this.speed; // Перемещение влево
        this.y += this.speed; // Перемещение вниз
    }

    moveDownRight() {
        this.x += this.speed; // Перемещение вправо
        this.y += this.speed; // Перемещение вниз
    }

    // Метод для обработки движения фигуры
    handleMovement(keysPressed) {
        if (keysPressed[this.keys.up] && keysPressed[this.keys.left]) {
            this.moveUpLeft(); // Движение вверх-влево
        } else if (keysPressed[this.keys.up] && keysPressed[this.keys.right]) {
            this.moveUpRight(); // Движение вверх-вправо
        } else if (keysPressed[this.keys.down] && keysPressed[this.keys.left]) {
            this.moveDownLeft(); // Движение вниз-влево
        } else if (keysPressed[this.keys.down] && keysPressed[this.keys.right]) {
            this.moveDownRight(); // Движение вниз-вправо
        } else if (keysPressed[this.keys.up]) {
            this.moveUp(); // Движение вверх
        } else if (keysPressed[this.keys.down]) {
            this.moveDown(); // Движение вниз
        } else if (keysPressed[this.keys.left]) {
            this.moveLeft(); // Движение влево
        } else if (keysPressed[this.keys.right]) {
            this.moveRight(); // Движение вправо
        }
    }
}