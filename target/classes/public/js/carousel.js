class Carousel {
    constructor() {
        this.currentIndex = 0;
        this.itemsPerView = 4;
        this.carousel = document.querySelector('.carrousel');
        this.cards = document.querySelectorAll('.card');
        this.prevBtn = document.querySelector('.carousel-btn--prev');
        this.nextBtn = document.querySelector('.carousel-btn--next');
        
        this.totalItems = this.cards.length;
        this.maxIndex = Math.max(0, this.totalItems - this.itemsPerView);
        
        this.init();
    }
    
    init() {
        this.updateButtons();
        this.showCurrentItems();
        
        this.prevBtn.addEventListener('click', () => this.prev());
        this.nextBtn.addEventListener('click', () => this.next());
    }
    
    showCurrentItems() {
        this.cards.forEach((card, index) => {
            if (index >= this.currentIndex && index < this.currentIndex + this.itemsPerView) {
                card.style.display = 'flex';
            } else {
                card.style.display = 'none';
            }
        });
    }
    
    prev() {
        if (this.currentIndex > 0) {
            this.currentIndex--;
            this.showCurrentItems();
            this.updateButtons();
        }
    }
    
    next() {
        if (this.currentIndex < this.maxIndex) {
            this.currentIndex++;
            this.showCurrentItems();
            this.updateButtons();
        }
    }
    
    updateButtons() {
        this.prevBtn.disabled = this.currentIndex === 0;
        this.nextBtn.disabled = this.currentIndex >= this.maxIndex;
        
        // Visual feedback for disabled buttons
        if (this.prevBtn.disabled) {
            this.prevBtn.style.opacity = '0.5';
            this.prevBtn.style.cursor = 'not-allowed';
        } else {
            this.prevBtn.style.opacity = '1';
            this.prevBtn.style.cursor = 'pointer';
        }
        
        if (this.nextBtn.disabled) {
            this.nextBtn.style.opacity = '0.5';
            this.nextBtn.style.cursor = 'not-allowed';
        } else {
            this.nextBtn.style.opacity = '1';
            this.nextBtn.style.cursor = 'pointer';
        }
    }
}

// Initialize carousel when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new Carousel();
});
