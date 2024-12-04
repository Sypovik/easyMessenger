import { Shape } from "./Shape.js";
import { Plot } from "./plot.js";


const plot = document.getElementById("gameCanvas");
const ctx = new Plot(plot.getContext("2d"), plot.width, plot.height);

const pleer1 = new Shape(100, 100, 50, 50, 'blue', { up: 'ArrowUp', down: 'ArrowDown', left: 'ArrowLeft', right: 'ArrowRight' })
const pleer2 = new Shape(200, 200, 50, 50, 'red', { up: 'w', down: 's', left: 'a', right: 'd' })

// Объект для отслеживания состояния нажатых клавиш
const keysPressed = {}; // Объект для хранения состояния нажатых клавиш

// Обработчик событий для клавиш стрелок
document.addEventListener('keydown', (event) => {
    keysPressed[event.key] = true; // Установка состояния клавиши в true при нажатии
});

document.addEventListener('keyup', (event) => {
    keysPressed[event.key] = false; // Установка состояния клавиши в false при отпускании
})

// Функция для обновления состояния игры с обработкой движения
function update() {
    [pleer1, pleer2].forEach(player => player.handleMovement(keysPressed)); // Обработка движения всех фигур
    ctx.draw([pleer1, pleer2]);
    requestAnimationFrame(update); // Запрос на повторный вызов функции update перед следующей перерисовкой
}

// Запуск игрового цикла
update(); // Первый вызов функции update для запуска игрового цикла
