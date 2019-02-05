from PIL import Image, ImageDraw
import os

field = Image.open('field.png')
scale = field.size[0] / 144

#draw = ImageDraw.Draw(field, mode="RGBA")
#draw.ellipse((0,0,100,100), fill=(255, 0, 0, 100))

#field.save('test.png')

dir = './paths/'
paths = os.listdir(dir)
for name in paths:
    if 'png' in name: continue
    out = Image.new('RGBA', field.size, (255, 255, 255, 0))
    d = ImageDraw.Draw(out, mode = "RGBA")
    path = open(dir + name, 'r').read()
    segments = path.split('\n\n')
    for segment in segments:
        segment = segment.split('\n')
        segment = [list(map(float, x.split(','))) for x in segment if len(x) > 2]
        for y, x, h, v in segment:
            x *= -1
            y *= -1
            x += 72
            y += 72
            x *= scale
            y *= scale
            s = 12 * scale
            #d.ellipse((x-s, y-s, x+s, y+s), fill = (255, 0, 0, 100))
            d.ellipse((x-v, y-v, x+v, y+v), fill = (255, 255, 0))
    out = Image.alpha_composite(field, out)
    out.save(dir + name.replace('csv', 'png'))
        

