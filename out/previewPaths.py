from PIL import Image, ImageDraw
import os
import math

field = Image.open('field.png')
scale = field.size[0] / 144

#draw = ImageDraw.Draw(field, mode="RGBA")
#draw.ellipse((0,0,100,100), fill=(255, 0, 0, 100))

#field.save('test.png')

dir = './paths/'
out = Image.new('RGBA', field.size, (255, 255, 255, 0))
d = ImageDraw.Draw(out, mode = "RGBA")
paths = os.listdir(dir)
for name in paths:
    #if not ('CRATER_CENTER_true' in name or 'DEPOT_LEFT_false' in name): continue
    print (name)
    if 'png' in name: continue
    path = open(dir + name, 'r').read()
    segment = path.split('\n')
    segment = [list(map(float, x.split(','))) for x in segment if len(x) > 2]
    i = 0
    c = 3 
    l = 1000
    for y, x, h, v in segment:
        x *= -1
        y *= -1
        x += 72
        y += 72
        x *= scale
        y *= scale
        v /= 2
        s = 12 * scale
        #d.ellipse((x-s, y-s, x+s, y+s), fill = (255, 0, 0, 100))
        if 'depot' in name: d.ellipse((x-v, y-v, x+v, y+v), fill = (255, 255, 0))
        else: d.ellipse((x-v, y-v, x+v, y+v), fill = (0, 255, 0))
        #if i%c == 0:
        #   d.line(((x, y), (x - math.sin(h) * l, y-math.cos(h) * l)), fill=(0,0,255), width=2)
        i += 1
out = Image.alpha_composite(field, out)
out.save(dir + 'nb.png')
        

