To run the program type ./build.sh in terminal [UBUNTU OR OTHER LINUX DISTRO] in the Angry_Bird folder and program should start running  
if it throws error try 'chmod +x build.sh' if error still exists type 'chmod +x gradlew'. If error still persists open it in **IDEA** and run 
the Lwjgl3Launcher file in lwjgl3 directory. 


Press "ENTER" to simulate completing a level in the levels page and "SPACE" to simulate losing a level 
Rest, the button which will guide you through the application 

LUCID = [UML && USE CASE](https://lucid.app/lucidchart/9cdbd809-feea-4b26-8d30-dec170930028/edit?invitationId=inv_56c42be7-6ee3-4b18-adf8-8ea852fdbb99&page=0_0#) 

Refrences  =>   Brent Aureli Codes       : [Youtube series](https://www.youtube.com/watch?v=a8MPxzkwBwo&list=PLZm85UZQLd2SXQzsF-a0-pPF6IWDDdrXt)  
                Philip Mod Dev           : [Youtube](https://www.youtube.com/watch?v=9UWEz5kf8Rs)               
                Image code button        : [stacks overflow](https://stackoverflow.com/questions/55731889/how-to-make-imagebutton-look-pressed-in-libgdx )
                Sample Project 1         : [Github](https://github.com/libgdx/libgdx-demo-superjumper) 
                Sample Project 2         : [Github](https://github.com/LonamiWebs/Klooni1010)
                Senior Project Tank Star : [Github](https://github.com/DhvanilSheth/Tank-Stars-Game)
                Tiled Tutorial           : [Youtube](https://www.youtube.com/watch?v=IHmF_bRpOAE) 
                Change Cursor            : [Game Development](https://gamedev.stackexchange.com/questions/86509/how-can-i-change-the-appearance-of-the-mouse-cursor-in-libgdx)
                Touch points             : [Official Documentation](https://libgdx.com/wiki/graphics/2d/scene2d/scene2d)
                Loading bar              : [Loading bar](https://libgdx.com/wiki/graphics/2d/scene2d/scene2d)
                AssetManager             : [asset manager](https://libgdx.com/wiki/graphics/2d/scene2d/scene2d)
                Build.sh config          : [Gradle](https://docs.gradle.org/current/userguide/gradle_wrapper_basics.html)
                SpriteBatch TextureRegion: [LibGDX Documentation](https://libgdx.com/wiki/graphics/2d/spritebatch-textureregions-and-sprites)
                Background Music         : [LibGDX Documentation](https://libgdx.com/wiki/audio/streaming-music)
                OrthographicCamera       : [GameFromScratch.com](https://gamefromscratch.com/libgdx-tutorial-part-16-cameras/)
                TiledMaploader           : [GameFromScratch.com](https://gamefromscratch.com/libgdx-tutorial-11-tiled-maps-part-1-simple-orthogonal-maps/)
                Box2D Video              : [The Coding Train ](https://youtube.com/watch?v=MsRROjQJxuo&list=PLRqwX-V7Uu6Zy4FyZtCHsZc_K0BrXzxfE&ab_channel=TheCodingTrain)
                Box2D Documentation      : [LibGdx Documentation](https://libgdx.com/wiki/extensions/physics/box2d)
                Physics youtube          : [dermetfan](https://www.youtube.com/playlist?list=PLXY8okVWvwZ2Ph9LKWiNBZ1GRAc_TyDru)
                Tiled 2D                 : [ForeignGuyMike](https://www.youtube.com/playlist?list=PLFqMllUBmHbhAGghZeZUp1mlrtsR7040T)
                User Inputs              : [Gamefromscratch](https://www.youtube.com/watch?v=Huifd-C2KrI&list=PLS9MbmO_ssyCZ9Tjfay2tOQoaOVoG59Iy&ab_channel=Gamefromscratch)
                

Resources =>    Adobe Premier && pixlr   : for textures creation and editing images
                AngryBirds apk file      : for assets and background music 
                AngryBirds Font          : [AngryBirdfont](https://www.dafont.com/angrybirds.font)

Our Final Directory at the end of this assignment
    └── Angry_Bird
    └── src
    ├── main
    │ └── java
    │     └── io
    │         └── github
    │             └── KunalSuman
    │                 └── Angry_Bird
    │                     ├── Birds
    │                     │   ├── Birds.java
    │                     │   ├── Birds_schema.java
    │                     │   ├── Black_bird.java
    │                     │   ├── Blue_bird.java
    │                     │   ├── Red_bird.java
    │                     │   └── Yellow_bird.java
    │                     ├── Button.java
    │                     ├── Catapult.java
    │                     ├── Collison.java
    │                     ├── Completed_Level.java
    │                     ├── Create_Bodies
    │                     │   ├── Birds_body.java
    │                     │   ├── Border_body.java
    │                     │   ├── Objects_body.java
    │                     │   ├── Pigs_body.java
    │                     │   └── Structure_body.java
    │                     ├── Create_body_Seralize
    │                     │   ├── Bird_body_serilizable.java
    │                     │   ├── Border_body_serilizable.java
    │                     │   ├── Object_body_seiralize.java
    │                     │   ├── Pigs_body_serilizable.java
    │                     │   └── Structure_body_serilizable.java
    │                     ├── End_level_helper_class.java
    │                     ├── Exceptions
    │                     │   ├── Load_Exception.java
    │                     │   ├── Login_Exception.java
    │                     │   └── Texture_Exception.java
    │                     ├── GameSaver.java
    │                     ├── Levels
    │                     │   ├── Level1.java
    │                     │   ├── Level2.java
    │                     │   ├── Level3.java
    │                     │   ├── Level4.java
    │                     │   ├── Level5.java
    │                     │   ├── Level_selector.java
    │                     │   └── Properties.java
    │                     ├── Loading_page.java
    │                     ├── LostLevel.java
    │                     ├── Main.java
    │                     ├── Menu_page.java
    │                     ├── New_pause.java
    │                     ├── PIGS
    │                     │    ├── Helmet_pig.java
    │                     │    ├── King_pig.java
    │                     │    ├── Old_pig.java
    │                     │    ├── Pigs.java
    │                     │    ├── Pigs_schema.java
    │                     │    └── Small_pig.java
    │                     ├── Pause.java
    │                     ├── Physics_Engine.java
    │                     ├── Quit.java
    │                     ├── Save_quit.java
    │                     ├── Settings_page.java
    │                     ├── StoryPage.java
    │                     ├── Unlocked_birds_page.java
    │                     └── savedGamesList.java
    └── test
        └── java
            └── tests
                ├── Test1.java
                ├── Test2.java
                ├── Test3.java
                ├── Test4.java
                └── Test5.java
