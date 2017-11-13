package team.girlsy.bean;

	public class Collection {
	    //收藏夹id
		private	Integer id;
		//收藏夹所有者
		private Custom custom;
		//收藏的物品
		private Goods goods;
		public  Collection() {
			super();
		}
		public Collection(Integer id, Custom custom, Goods goods) {
			super();
			this.id = id;
			this.custom = custom;
			this.goods = goods;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Custom getCustom() {
			return custom;
		}
		public void setCustom(Custom custom) {
			this.custom = custom;
		}
		public Goods getGoods() {
			return goods;
		}
		public void setGoods(Goods goods) {
			this.goods = goods;
		}
			
			
		}


