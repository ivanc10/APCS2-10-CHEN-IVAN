ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c: particles) {
    int collisions = 0;
    for (Cow b: particles) {
      if (b!=c && touching(b, c) ) {
        collisions++;
      }
    }
      c.colliding = collisions > 0;
  }
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   if (mousePressed && mouseButton == RIGHT) {
     Cow moo = new Cow();
     moo.x = (float) mouseX;
     moo.y = (float) mouseY;
     particles.add(moo);
   }
   //Left click: call the click of each cow 
   if (mousePressed && mouseButton == LEFT) {
     for (Cow a: particles) {
       a.click();
     }
   }
}

void keyPressed() {
  if (keyCode == 32) {
    particles.clear();
  }
  //println(keyCode);
}

boolean touching(Cow a, Cow b) {
  return dist(a.x, a.y, b.x, b.y) <= a.radius+b.radius;
}
