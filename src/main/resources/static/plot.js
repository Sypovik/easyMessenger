export class Plot {
    constructor(ctx, width, height) {
        this.ctx = ctx
        this.width = width
        this.height = height
    }

    draw(pleers) {
        this.ctx.clearRect(0, 0, this.width, this.height);

        pleers.map(pleer => {
            this.ctx.fillStyle = pleer.color; // Установка цвета заливки
            this.ctx.fillRect(pleer.x, pleer.y, pleer.width, pleer.height); // Рисование прямоуголь
        })
    }

}
console.log('plot');
