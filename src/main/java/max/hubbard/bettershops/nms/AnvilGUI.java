package max.hubbard.bettershops.nms;


import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public interface AnvilGUI {

    enum AnvilSlot {
        INPUT_LEFT(0),
        INPUT_RIGHT(1),
        OUTPUT(2);

        private final int slot;

        AnvilSlot(int slot){
            this.slot = slot;
        }

        public int getSlot(){
            return slot;
        }

        public static AnvilSlot bySlot(int slot){
            for(AnvilSlot anvilSlot : values()){
                if(anvilSlot.getSlot() == slot){
                    return anvilSlot;
                }
            }

            return null;
        }
    }

    void doGUIThing(Player player, final AnvilClickEventHandler handler);

    class AnvilClickEvent {
        private AnvilSlot slot;

        private String name;

        private boolean close = true;
        private boolean destroy = true;

        private ItemStack item;
        private HumanEntity entity;

        public AnvilClickEvent(AnvilSlot slot, String name, ItemStack it, HumanEntity ent){
            this.slot = slot;
            this.name = name;
            this.item = it;
            this.entity = ent;
        }

        public AnvilClickEvent() {

        }

        public int getSlot(){
            return slot.getSlot();
        }

        public ItemStack getCurrentItem(){
            return item;
        }

        public HumanEntity getWhoClicked(){
            return entity;
        }

        public String getName(){
            return name;
        }

        public boolean getWillClose(){
            return close;
        }

        public void setWillClose(boolean close){
            this.close = close;
        }

        public boolean getWillDestroy(){
            return destroy;
        }

        public void setWillDestroy(boolean destroy){
            this.destroy = destroy;
        }
    }

    interface AnvilClickEventHandler {


        void onAnvilClick(AnvilClickEvent ev);
    }

    Player player = null;

    AnvilClickEventHandler handler = null;

    HashMap<AnvilSlot, ItemStack> items = new HashMap<AnvilSlot, ItemStack>();

    Inventory inv = null;

    Listener listener = null;

    Player getPlayer();

    void setSlot(AnvilSlot slot, ItemStack item);

    void open();

    void destroy();
}
