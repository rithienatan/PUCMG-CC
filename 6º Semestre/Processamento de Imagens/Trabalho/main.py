### ---------- Imports ----------
from tkinter import *
from PIL import ImageTk,Image


### ---------- Custom Modules Imports ----------
import buttonsFunctions as bf


### ---------- Set window ----------
root = Tk()
root.title('Reconhecimento de padrões por textura em imagens mamográficas')

frame = Frame(root, width = 1440, height = 780)
frame.pack(expand = TRUE, fill = BOTH)

window = Canvas(frame, width = 1440, height = 780, scrollregion = (0, 0, 500, 500))
window.pack()


### ---------- Set buttons for window ----------
zoomIn = Button(window, text = "Zoom In +", command = bf.zoomInClick())
zoomIn.place(x = 0, y = 0)

zoomOut = Button(window, text = "Zoom Out -", command = bf.zoomOutClick())
zoomOut.place(x = 70, y = 0)

resolution64 = Button(window, text = "Resolution in 64 pixels", command = bf.resolution64Click())
resolution64.place(x = 145, y = 0)

resolution32 = Button(window, text = "Resolution in 32 pixels", command = bf.resolution32Click())
resolution32.place(x = 275, y = 0)

resolutionBack = Button(window, text = "Back to normal resolution", command = bf.resolutionBackClick())
resolutionBack.place(x = 405, y = 0)

quantization256 = Button(window, text = "Quantization 256 shade of grey", command = bf.quantization256Click())
quantization256.place(x = 555, y = 0)

quantization32 = Button(window, text = "Quantization 32 shade of grey", command = bf.quantization32Click())
quantization32.place(x = 730, y = 0)

quantization16 = Button(window, text = "Quantization 16 shade of grey", command = bf.quantization16Click())
quantization16.place(x = 900, y = 0)

equalize = Button(window, text = "Equalizer", command = bf.equalizeClick())
equalize.place(x = 1070, y = 0)


### ---------- Read image ----------
defaultWidth = 600
defaultHeight = 700

picture = Image.open('Images/d_left_mlo (44).png')
resizeImg = picture.resize((defaultWidth, defaultHeight), Image.ANTIALIAS)
displayImg = ImageTk.PhotoImage(resizeImg)
#picture = ImageTk.PhotoImage(Image.open('Images/d_left_mlo (44).png'))
window.create_image(300, 30, anchor = NW, image = displayImg)


### ---------- Running window ----------
window.mainloop()