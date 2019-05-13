package com.hyd.fxwidgets.layout;

import javafx.stage.Stage;

public class ComplexLayoutTest extends LayoutHelperApplication {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(scene(vbox(0, 0,
            menuBar(
                menu("文件",
                    menuItem("新建", null),
                    menuItem("打开...", null),
                    menuItem("保存", null),
                    menuItem("另存为...", null),
                    menuItem("退出", null)
                ),
                menu("编辑"),
                menu("视图"),
                menu("工具"),
                menu("帮助")
            ),
            vbox(new double[]{100, 200, 100, 200}, 0)
        )));

        stage.show();
    }
}
