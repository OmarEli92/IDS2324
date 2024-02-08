//crea l'oggetto map e imposta la latitudine e longitudine iniziale e lo zoom
var map = L.map('map').setView([42.9904967, 13.8687605], 16);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

