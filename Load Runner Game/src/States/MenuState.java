package States;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import tilegame.Game;
import tilegame.Handler;
import tilegame.UserInterface.ClickListener;
import tilegame.UserInterface.UIImageButton;
import tilegame.UserInterface.UIManager;

public class MenuState extends State{

    private UIManager uiManager;
    
    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
        handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

    
    
}
