# KG2020_G41_Task1
Random planets & stars generation
В таске имеются:

Класс DrawPanel, тут задаются все переменные, которые после передаются другим классам

Класс Star, В DrawPanel звезды в цикле рисуются с рандомными координатами, полурандомным размером, количеством и относительной длиной луча и количеством лучей, есть возможность задавать им поворот и цвет

Класс RingedPlanet, планета с кольцами. Рандомные с ограничениями координаты, полурандомные размер, количество колец, цвета, шаг градиента и поворот

Класс Moon Planet, спутник планеты с кольцами. Так же с координатами, размером и цветом, поворота нет так как он и не нужен, тестура реализована заливкой круга, исключением из него меньших кругов разного размера и заливки другим цветом

Класс ISS Window, туда передается ширина и высота окна, а также старая и немного модифицированная шутка в духе Петросяна, за которую я извиняюсь. Суть шутки в форточке на космической станции, которую класс и рисует. Классы, описанные дальше, используются внутри этого

Класс smoothCornerRect, возвращает Area-прямоугольник со скругленными углами методом getSRC(), кроме стандартных для прямоугольника координат начала, ширины и высоты имеет задаваемый радиус угла

Класс Logo, полученный в ходе попыток исправить кривые кольца у планеты. Так и не исправил 

Очень много используется Area, не описанная в методичке, вместе с areaName1.substract(areaName2) (исключение) и areaName1.add(areaName2) (добавление)

Также используется не описанный в методичке, но найденный мной на просторах интернета .setComposite(), вот пример:

gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));

gr.fillRect(0,0,width,height);

gr.setComposite(oldComposite);

Здесь он затемняет окно, и по сути это установка полупрозручного фильтра в Graphics2D

Также были добавлены примеры того, что в итоге получается
